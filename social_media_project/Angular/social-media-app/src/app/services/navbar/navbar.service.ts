import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NavbarService {

  visible: boolean;

  constructor() { this.visible = false; }
  // hide navbar
  hide() { this.visible = false; }
  //show navbar
  show() { this.visible = true; }
  //toggle navbar
  toggle() { this.visible = !this.visible; }
}
