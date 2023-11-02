<template>
    <div>
        <div class="py-5 text-center">
            <h2>회원가입</h2>
        </div>

        <div class="container d-flex align-items-center justify-content-center">
            <div class="col-md-7 col-lg-8">
                <form class="needs-validation" novalidate>
                    <div class="row g-3">
                        <div class="col-12">
                            <label for="userId" class="form-label">아이디</label>
                            <input type="text" class="form-control" v-model="state.form.userId" >
                            <div class="form-feedback" v-show="state.error.userId">
                                아이디를 입력하세요.
                            </div>

                            <label for="password" class="form-label">비밀번호</label>
                            <input type="text" class="form-control"  v-model="state.form.password" >
                            <div class="form-feedback" v-show="state.error.password">
                                비밀번호를 입력하세요.
                            </div>

                            <label for="name" class="form-label">이름</label>
                            <input type="text" class="form-control"  v-model="state.form.name" >
                            <div class="form-feedback" v-show="state.error.name">
                                이름을 입력하세요.
                            </div>

                            <label for="email" class="form-label">Email <span
                                    class="text-muted">(Optional)</span></label>
                            <input type="email" class="form-control" id="email"  v-model="state.form.email" placeholder="you@example.com">
                            <div class="form-feedback" v-show="state.error.email">
                                이메일를 입력하세요.
                            </div>


                            <label for="phoneNumber" class="form-label">휴대번호</label>
                            <input type="text" class="form-control" placeholder="" v-model="state.form.phoneNumber" >
                            <div class="form-feedback" v-show="state.error.phoneNumber">
                                휴대번호를 입력하세요.
                            </div>


                            <label for="birthday" class="form-label">생년월일</label>
                            <div class="row">
                                <div class="col-md-5">
                                    <input type="number" class="form-control" v-model="state.year" placeholder="년(4자)">
                                </div>
                                <div class="col-md-4">
                                    <select class="form-select" v-model="state.month">
                                        <option value="">월</option>
                                        <option value="01">1월</option>
                                        <option value="02">2월</option>
                                        <option value="03">3월</option>
                                        <option value="04">4월</option>
                                        <option value="05">5월</option>
                                        <option value="06">6월</option>
                                        <option value="07">7월</option>
                                        <option value="08">8월</option>
                                        <option value="09">9월</option>
                                        <option value="10">10월</option>
                                        <option value="11">11월</option>
                                        <option value="12">12월</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <input type="number" class="form-control" v-model="state.day" placeholder="일">
                                </div>

                            </div>
                        </div>

                    </div>

                    <hr class="my-4">

                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" v-model="state.form.admin">
                        <label class="form-check-label" >관리자</label>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="button" @click="submit()">회원가입</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";

export default {
    name: "SignUp",

    setup(){
        const state = reactive({
            form:{
                userId:"",
                password:"",
                name:"",
                email:"",
                phoneNumber:"",
                birthday: "",
                admin:false
            },
            year:"",
            month:"",
            day:"",
            error:{
                userId:false,
                password:false,
                name:false,
                email:false,
                phoneNumber:false,
                birthday: false,
            }

        })
        const submit = () => {
            state.error.userId = state.form.userId == ""
            state.error.password = state.form.password == ""
            state.error.name = state.form.name == ""
            state.error.email = state.form.email == ""
            state.error.phoneNumber = state.form.phoneNumber == ""


            state.form.birthday = state.year + state.month + state.year
            console.log(state.form)
            axios.post("/api/account/signup", state.form).then((res)=>{
                console.log(res)
            })
        }
        return {state,submit}
    }

}
</script>

<style scoped>
.form-feedback{
    width: 100%;
    margin-top: 0.25rem;
    font-size: .875em;
    color: #dc3545;
}
</style>



