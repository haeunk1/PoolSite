<template>
<div>
    <div class="text-center py-5">
        <h1>자기소개서 관리</h1>
        <p class="lead">같은 정보를 매번 지원할 때마다 입력하는 것 그만!</p>
        <p class="lead">
            <button class="btn btn-lg btn-secondary fw-bold border-white bg-black" @click="moveInsertPage()">자소서 입력하러 가기</button>
        </p>
    </div>
</div>
</template>

<script>


import store from "@/scripts/store";
import router from "@/scripts/router";

export default {
    name: "Home",
    setup(){
        const moveInsertPage = () => {
            if(store.state.token == null && store.state.account.id == 0){
                router.push({path:'/login'})
            }else{
                router.push({path:'/selfIntroduction'})
            }
        }

        return {moveInsertPage}
    }

}
</script>

<style scoped>

</style>