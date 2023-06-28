import { RouterModule, Routes } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { NavComponent } from './nav/nav.component';
import { userService } from './users/users.service';
import { NewUserComponent } from './users/new-user.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';


const routes: Routes = [{path:"", redirectTo:"login", pathMatch:"full"},
{path:"users", component: UsersComponent},
{path:"users/new-user", component:NewUserComponent},
{path:"login", component:LoginComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    NavComponent,
    NewUserComponent,
    LoginComponent,
    FooterComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [userService],
  bootstrap: [AppComponent]
})
export class AppModule { }
