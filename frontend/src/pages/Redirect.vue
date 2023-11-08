<template>
<div>
    <div>
        로그인 성공
    </div>
</div>
</template>

<script>


import store from "@/scripts/store";
import router from "@/scripts/router";

export default {
    name: "Redirect",
    setup(){
        //const token = this.$route.query.token
        const token = new URL(window.location.href).searchParams.get('token');
        console.log(token)
        if(token){
            store.commit('setToken',token)
            sessionStorage.setItem("acessToken",token)
            window.alert("로그인하였습니다.")
            router.push({path:'/'})
        }else{
            window.alert("로그인에 실패하였습니다.")
            router.push({path:'/login'})
        }
    }


}
</script>

<style scoped>

</style>