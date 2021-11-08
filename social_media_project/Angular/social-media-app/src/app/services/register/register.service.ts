import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IUser } from '../../models/user';
import { UserService } from '../user/user.service';

@Injectable()
export class RegisterService {
  submit(newUser: UserService) {
    throw new Error('Method not implemented.');
  }

  private url: string = "http://localhost:9005/socialMediaWebApp/api/userAccount/createAccount/";

  constructor(private httpCli: HttpClient) { }

  // post request to createAccount
  registerRequest(newUser: IUser) {
    return this.httpCli.post(this.url, newUser, {withCredentials: true});
  }
}


