import { Component } from '@angular/core';
import { ServicesService } from './services/services.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  content1: any;
  content2: any;

  str:any;

  constructor(private serve:ServicesService){}
  title = 'secondApp';
isDisplay=false;
toggleDisplay(){
  this.isDisplay=!this.isDisplay;
}
ngOnInit(): void {
  this.diningCount();
  this.serviceCount();
}
diningCount()
{
  this.serve.getCountOfDiningArea().subscribe(data1=>{
    this.content1=data1;
  })
  if(this.content1>=130)
{
  this.str="Crowded";
}
else if(this.content1>=80&&this.content1<=110)
{
  this.str="Moderate"
}
else{
  this.str="Free"
}

}
serviceCount()
{
  this.serve.getCountOfServiceArea().subscribe(data2=>{
    this.content2=data2;
  })
  if(this.content2>=130)
  {
    this.str="Crowded";
  }
  else if(this.content2>=80&&this.content2<=110)
  {
    this.str="Moderate"
  }
  else{
    this.str="Free"
  }
}




}


