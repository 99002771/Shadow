import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ChartComponent } from './chart/chart.component';
import { Chart2Component } from './chart2/chart2.component';
import {MatTabsModule} from '@angular/material/tabs';
import {MatToolbarModule} from'@angular/material/toolbar';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input'
import {MatNativeDateModule} from '@angular/material/core';
import { HistoricalComponent } from './historical/historical.component';
import { Historical2Component } from './historical2/historical2.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import {HttpClientModule} from '@angular/common/http';



@NgModule({
   declarations: [
      AppComponent,
      ChartComponent,
      Chart2Component,
      HistoricalComponent,
      Historical2Component,
    
     
   ],
   imports: [
      BrowserModule,
      BrowserAnimationsModule,
      MatDatepickerModule, MatInputModule,MatNativeDateModule,
     MatCardModule,
     MatButtonModule,
      FormsModule,
      ReactiveFormsModule,
      MatTabsModule,
      MatTooltipModule,
      MatToolbarModule,
      HttpClientModule
   ],
   providers: [],
   bootstrap: [AppComponent]
})
export class AppModule { }