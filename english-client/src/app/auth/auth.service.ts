import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ApiService} from "../shared/backend.api";

@Injectable()
export class AuthService {
    constructor(private http: HttpClient,
                private apiService: ApiService) {
    }

    login(user: any): void {
        this.http.post(this.apiService.loginUrl, user)
            .subscribe(next => {
                console.log(next);
            });
    }
}
