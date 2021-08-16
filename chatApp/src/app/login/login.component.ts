import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  user: FormGroup;

  constructor() {
    this.user = new FormGroup({
      username: new FormControl('',  Validators.compose([Validators.required, Validators.email])),
      password: new FormControl(
        '',
        Validators.compose([Validators.minLength(6), Validators.required])
      ),
    });
  }

  ngOnInit(): void {}

  formGroupIsValid() {
    return !(this.user.get('username')?.invalid || this.user.get('password')?.invalid);
  }
  submit() {
  }
}
