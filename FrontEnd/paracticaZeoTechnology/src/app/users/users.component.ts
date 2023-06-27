import { Component } from '@angular/core';
import { User } from './user';
import { userService } from './users.service';
import swal from "sweetalert2";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  users: User[]=[]

  constructor(private userService: userService){}
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.userService.getUsers().subscribe(
    users => {this.users = users}
    );
  }
}

