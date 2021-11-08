import { Injectable } from '@angular/core';
import { NavigationStart, Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Alert, AlertType } from 'src/app/models/alert';

@Injectable()
export class AlertService {

    private subject = new Subject<Alert>();
    private keepAfterRouteChange = false;

    // keep or remove alert after route change
    constructor(private router: Router) {
        router.events.subscribe(eve => {
            if (eve instanceof NavigationStart) {
                if (this.keepAfterRouteChange) {
                    this.keepAfterRouteChange = false;
                } else {
                    this.clear();
                }
            }
        });
    }

    // get alert
    getAlert(): Observable<any> {
        return this.subject.asObservable();
    }

    // success message
    success(message: string, keepAfterRouteChange = false) {
        this.clear()
        this.alert(AlertType.Success, message, keepAfterRouteChange);
    }

    // error message
    error(message: string, keepAfterRouteChange = false) {
        this.clear()
        this.alert(AlertType.Error, message, keepAfterRouteChange);
    }

    // info message
    info(message: string, keepAfterRouteChange = false) {
        this.clear()
        this.alert(AlertType.Info, message, keepAfterRouteChange);
    }

    // warn message
    warn(message: string, keepAfterRouteChange = false) {
        this.clear()
        this.alert(AlertType.Warning, message, keepAfterRouteChange);
    }

    // alert
    alert(type: AlertType, message: string, keepAfterRouteChange = false) {
        this.keepAfterRouteChange = keepAfterRouteChange;
        this.subject.next(<Alert>{ type: type, message: message });
    }
    
    // clear alerts
    clear() {
        this.subject.next();
    }
}
