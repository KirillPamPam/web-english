import {EngLocalizationService, LocalizationService} from "./shared/localization.service";
import {AuthService} from "./auth/auth.service";
import {ApiService} from "./shared/backend.api";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {TokenInterceptorService} from "./shared/token.service";
import {ErrorsHandler} from "./shared/error-handler";

export const Providers: any = [
    {provide: LocalizationService, useClass: EngLocalizationService},
    {provide: AuthService, useClass: AuthService},
    {provide: ApiService, useClass: ApiService},
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptorService, multi: true},
    {provide: ErrorsHandler, useClass: ErrorsHandler}
];
