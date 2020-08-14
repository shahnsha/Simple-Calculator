import { Component } from '@angular/core';
import { freeApiService } from './services/freeApi.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'myApiDemo';

  constructor(private _freeApiService: freeApiService) { }

  currentNumber = '0';
  firstOperand = null;
  operator = null;
  waitForSecondNumber = false;
  result: number;

  ngOnInit() {
  }

  public getNumber(v: string) {
    console.log(v);
    if (this.waitForSecondNumber) {
      this.currentNumber = v;
      this.waitForSecondNumber = false;
    } else {
      this.currentNumber === '0' ? this.currentNumber = v : this.currentNumber += v;

    }
  }

  getDecimal() {
    if (!this.currentNumber.includes('.')) {
      this.currentNumber += '.';
    }
  }

  private doCalculation(op, secondOp) {
    switch (op) {
      case '+':
        return this.firstOperand += secondOp;
      case '-':
        return this.firstOperand -= secondOp;
      case '*':
        return this.firstOperand *= secondOp;
      case '/':
        return this.firstOperand /= secondOp;
      case '=':
        return secondOp;
    }
  }

  private async doCalculationFromAPI(op, secondOp) {
    const myObj = {
      numbers: [this.firstOperand, Number(this.currentNumber)]
    };
    const myObjStr = JSON.stringify(myObj);
    switch (op) {
      case '+':
        return await this._freeApiService.postAddition(myObjStr);
      case '-':
        return await this._freeApiService.postSubtraction(myObjStr);
      case '*':
        return await this._freeApiService.postMultiplication(myObjStr);
      case '/':
        return await this._freeApiService.postDivision(myObjStr);
      case '=':
        return secondOp;
    }
  }

  public getOperation(op: string) {
    console.log("first click:" + op);

    if (this.firstOperand === null) {
      this.firstOperand = Number(this.currentNumber);

    } else if (this.operator) {
      const result = this.doCalculation(this.operator, Number(this.currentNumber))
      //const resultApi = this.doCalculationFromAPI(this.operator, Number(this.currentNumber))

      this.currentNumber = String(result);
      this.firstOperand = result;
    }
    this.operator = op;
    this.waitForSecondNumber = true;
  }

  public clear() {
    this.currentNumber = '0';
    this.firstOperand = null;
    this.operator = null;
    this.waitForSecondNumber = false;
  }
}
