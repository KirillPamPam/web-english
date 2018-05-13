import {EngLocalizationService, LocalizationService} from "./shared/localization.service";
import {AuthService} from "./auth/auth.service";
import {ApiService} from "./shared/backend.api";

export const Providers: any = [
    {provide: LocalizationService, useClass: EngLocalizationService},
    {provide: AuthService, useClass: AuthService},
    {provide: ApiService, useClass: ApiService}
];
