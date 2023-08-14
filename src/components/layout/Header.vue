<template>
    <div id="header">
<<<<<<< HEAD
        <h1>KosLetter</h1>
        <div id="mypage">
            <a href="http://localhost:8080/about">
                <h2>{{username}}1111</h2>
            </a>
=======
        <img id='titleLogo' @click='goHome' src="../../assets/kosletter.png" />
        <div id="myInfo">
            <h2 @click='goAbout'>닉네임</h2>
>>>>>>> backup
            <h3>220코인</h3>
            <b-button>코인 사용하기</b-button>
        </div>
    </div>
</template>

<script>
export default {
    name : "header",
<<<<<<< HEAD
    props:['username'],//데이터받기
};
</script>

<style>
@font-face {
    font-family: 'ChosunBg';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@1.0/ChosunBg.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
=======
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
>>>>>>> backup
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
