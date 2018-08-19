import {Injectable} from "@angular/core";
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {ApiService} from "../shared/backend.api";
import "rxjs/add/operator/catch";
import {Router} from "@angular/router";
import {Store} from "@ngrx/store";
import {ErrorsHandler} from "../shared/error-handler";

@Injectable()
export class AuthService {
    constructor(private http: HttpClient,
                private apiService: ApiService,
                private router: Router,
                private store: Store<any>,
                private errorService: ErrorsHandler) {
    }

    login(user: any): void {
        this.http
            .post(this.apiService.loginUrl, user, {observe: "response"})
            .subscribe(resp => {
                this.store.dispatch({type: "FAIL_LOGIN", payload: {fail: false, message: ""}})
                this.router.navigateByUrl("/main");
                localStorage.setItem("token",resp.headers.get("Authorization"));
            }, err => {
                this.errorService.handleError(err);
            });
    }

    test() {
        this.http
            .get(this.apiService.test)
            .subscribe(resp => {
            }, err => {
                this.errorService.handleError(err);
            });
    }

    getToken(): string {
        return localStorage.getItem("token");
    }
}
