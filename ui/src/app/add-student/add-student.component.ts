import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentsComponent implements OnInit {
  studentForms : FormGroup;
  constructor(private formbuilder : FormBuilder,private http:HttpClient,private router :Router) {
    this.studentForms = this.formbuilder.group({
      name: ['',Validators.required],
      department: ['',Validators.required],
      rollnumber: ['',Validators.required],
      birthdate: ['',Validators.required],
      mobilenumber: ['',Validators.required]
    })
   }

  ngOnInit(): void {
  }
  saveStudent(){
    let studentData = this.studentForms.value;
    this.http.post('http://localhost:8081/students/savestudent',studentData)
    .subscribe(response => {
      console.log('Student saved DB', response)
      this.router.navigateByUrl('/student')
    }, error =>{
      console.error('Error in student save', error)
    }
    );
  }
}
