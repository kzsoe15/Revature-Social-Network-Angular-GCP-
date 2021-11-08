import { Injectable } from '@angular/core';

@Injectable()
export class PasswordTokenService {

  private passwordToken!:string

  constructor() { }

  // set password token
  set passToken(token:string) {
    this.passwordToken = token;
  } 

  // get password token
  get passToken():string {
    return this.passwordToken;
  }

}
