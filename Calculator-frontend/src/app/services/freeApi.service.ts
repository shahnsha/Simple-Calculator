import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class freeApiService {
    constructor(private httpclient: HttpClient) { }

    _url = "http://localhost:8080/calculator/";

    async postAddition(operation: string) {
        return this.httpclient.post(this._url + "add", operation).toPromise();
    }

    async postSubtraction(operation: string) {
        return this.httpclient.post(this._url + "sub", operation).toPromise();
    }

    async postMultiplication(operation: string) {
        return this.httpclient.post(this._url + "mul", operation).toPromise();
    }

    async postDivision(operation: string) {
        return this.httpclient.post(this._url + "div", operation).toPromise();
    }
}