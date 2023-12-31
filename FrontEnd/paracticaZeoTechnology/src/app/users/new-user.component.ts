import { User } from './user';
import { userService } from './users.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ThisReceiver } from '@angular/compiler';
import swal  from 'sweetalert2';
import { BootstrapOptions } from '@angular/core';


@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
})
export class NewUserComponent implements OnInit{
  ngOnInit(): void {
    //throw new Error('Method not implemented.');
  }

  public user:User = new User;
  
  show:boolean=false
  public titulo:string = "Alta de Usuarios"
  
  constructor(private userService:userService,private router:Router, private activatedRoute:ActivatedRoute){}

  public create():void{


    this.userService.create(this.user).subscribe(
      user => 
      {
        this.show=true
        console.log(this.show)
        this.router.navigate(['/users'])
        swal.fire('Nuevo Usuario', `Usuario ${this.user.name}  creado con exito`, 'success')
    
        
        
    }
    )
  }
}


