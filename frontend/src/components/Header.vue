<template>

    <header data-bs-theme="dark">
        <div class="collapse bg-dark" id="navbarHeader">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 py-4">
                        <h4 class="text-white">사이트맵</h4>
                        <ul class="list-unstyled">
                            <li>
                                <router-link to="/" class="text-white">메인화면</router-link>
                            </li>
                            <li v-if="$store.state.account.id">
                                <router-link to="/orders" class="text-white">주문내역</router-link>
                            </li>
                            <li>
                                <router-link to="/login" class="text-white" v-if="$store.state.account.id == 0 && $store.state.token == null">로그인
                                </router-link>
                                <a to="/login" class="text-white" @click="logout()" v-else>로그아웃</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="navbar navbar-dark bg-dark shadow-sm">
            <div class="container">
                <router-link to="/" class="navbar-brand d-flex align-items-center">
                    <img class="bi me-2" width="55" height="55" src="../assets/logo.png" />
                    <strong>PoolSite</strong>
                </router-link>

                <router-link to="/cart" class="cart btn"  v-if="$store.state.account.id"><i class="fa fa-shopping-cart" aria-hidden="true"></i></router-link>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader"
                        aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </div>
    </header>

</template>

<script>
// import store from "@/scripts/store";
// import router from "@/scripts/router";
// import axios from "axios";


export default {
    name: 'Header',
    setup() {
        const logout = () => {
            // axios.post("/api/account/logout").then(()=>{
            //     store.commit("setAccount", 0)
            //     router.push({path: "/"})
            //
            // })

            sessionStorage.removeItem("id")
        }
        return {logout}
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
header .navbar .cart {
    margin-left: auto;
    color: #fff;
}
header ul li a{
    cursor : pointer;
    color: #eee;
}
</style>
