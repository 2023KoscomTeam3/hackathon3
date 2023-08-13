<template>
    <div id="header">
        <img id='titleLogo' @click='goHome' src="../../assets/kosletter.png" />
        <div id="myInfo">
            <h2 @click='goAbout'>닉네임</h2>
            <h3>220코인</h3>
            <b-button>코인 사용하기</b-button>
        </div>
    </div>
</template>

<script>
export default {
    name : "header",
    data()  {
        return {
            isHome : true
        }
    },
    methods : {
        goHome()    {
            if (this.$route.path == '/home') {
                console.log("isHome")
            } else  {
                this.$router.push('/home');
            }
        },
        goAbout() {
            if (this.$route.path == '/about') {
                console.log("isAbout")
            } else  {
                this.$router.push('/about');
            }
        }
    },
};
</script>

<style scoped>
#header {
    height : 150px;
    background-color : #e5e3e1;
    display: flex;
    justify-content: flex-start;
    padding : 15px;
}
#myInfo {
    margin-left : 700px;
}
</style>
