import { UsersComponent } from './users/users.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewUserComponent } from './users/new-user.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [{path:"", redirectTo:"login", pathMatch:"full"},
{path:"users", component: UsersComponent},
{path:"users/new-user", component:NewUserComponent},
{path:"login", component:LoginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

  
}
