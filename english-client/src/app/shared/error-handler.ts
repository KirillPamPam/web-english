import {ErrorHandler, Injectable, Injector} from "@angular/core";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Store} from "@ngrx/store";
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ErrorsHandler {

    constructor(private injector: Injector,
                private store: Store<any>) {
    }

    handleError(error: any) {
        if (error instanceof HttpErrorResponse) {
            if (error.status === 401) {
                this.store.dispatch({type: "AUTH_LOGIN", payload: {fail: true, message: error.error}});
            }
            if (error.status === 403) {
                let router = this.injector.get(Router);
                window.location.reload(true);
                router.navigateByUrl("/auth/error");
            }
        }
        console.error(error);
    }
}