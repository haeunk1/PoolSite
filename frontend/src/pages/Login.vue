<template>
    <div class="form-signin w-100 m-auto">
<!--            <img class="mb-4" src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">-->
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

            <div class="form-floating">
                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" v-model="state.form.userId" @keyup.enter="submit()">
                <label for="floatingInput">id</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password" v-model="state.form.password" @keyup.enter="submit()">
                <label for="floatingPassword">Password</label>
            </div>

            <div class="form-check text-start my-3">
                <div class="text-left">
                <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault" @keyup.enter="submit()">
                <label class="form-check-label" for="flexCheckDefault">
                    Remember me
                </label>
                </div>
                <div class="text-right">
                <router-link to="/signUp">회원가입</router-link>
                </div>
            </div>
            <button class="btn btn-primary w-100 py-2" @click="submit()">Sign in</button>
            <div class="col-md-12">
                <div class="login-or">
                    <hr class="hr-or">
                    <span class="span-or">or</span>
                </div>
            </div>

        <div class="form-group d-flex justify-content-center">
            <a href="http://localhost:8080/oauth2/authorize/google?redirect_uri=http://localhost:3000/Redirect">
                <img class="bi me-2" width="55" height="55" src="../assets/img/google.png" />
            </a>
            <a href="http://localhost:8080/oauth2/authorize/naver?redirect_uri=http://localhost:3000/Redirect">
                <img class="bi me-2" width="55" height="55" src="../assets/img/naver.png" />
            </a>
            <a href="http://localhost:8080/oauth2/authorize/kakao?redirect_uri=http://localhost:3000/Redirect">
                <img class="bi me-2" width="55" height="55" src="../assets/img/kakao.png" />
            </a>
        </div>


    </div>
</template>

<script>
import {reactive} from "vue";
import axios from "axios";
import store from "@/scripts/store";
import router from "@/scripts/router";

export default {
    setup(){
        const state = reactive({
            form:{
                userId:"",
                password:""
            }
        })

        const submit = () => {
            axios.post("/api/account/login", state.form).then((res)=>{
                store.commit('setAccount', res.data)
                sessionStorage.setItem("id",res.data)//아이디 값 저장
                router.push({path: "/"})
                window.alert("로그인하였습니다.")
            }).catch(()=>{
                window.alert("로그인 정보가 존재하지 않습니다.")
            })
        }


        return {state,submit}


    }


}
</script>

<style scoped>
.form-signin {
    max-width: 330px;
    padding: 1rem;
}

.form-signin .form-floating:focus-within {
    z-index: 2;
}

.form-signin input[type="email"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.login-or {
    position: relative;
    color: #aaa;
    margin-top: 10px;
    margin-bottom: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
}

.span-or {
    display: block;
    position: absolute;
    left: 50%;
    top: -2px;
    margin-left: -25px;
    background-color: #fff;
    width: 50px;
    text-align: center;
}

.hr-or {
    height: 1px;
    margin-top: 0px !important;
    margin-bottom: 0px !important;
}
</style>