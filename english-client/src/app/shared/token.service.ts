import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Injectable} from "@angular/core";
import {AuthService} from "../auth/auth.service";
import {ApiService} from "./backend.api";

@Injectable()
export class TokenInterceptorService implements HttpInterceptor {

    constructor(private authService: AuthService,
                private apiService: ApiService) {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (req.url !== this.apiService.loginUrl) {
            req = req.clone({
                setHeaders: {
                    Authorization: this.authService.getToken()
                }
            });
        }
        return next.handle(req);
    }
}