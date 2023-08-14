<template>
    <div id="header">
        <img id="titleLogo" @click='goHome'  src="../../assets/kosletter.png"/>
        <div id="mypage">
            <h2 @click='goAbout'> {{ username }}1111</h2>
            <h3>220코인</h3>
            <b-button>코인 사용하기</b-button>
        </div>
    </div>
</template>

<script>
export default {
    name : "header",
    props:['username'],//데이터받기
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

<style>
@font-face {
    font-family: 'ChosunBg';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@1.0/ChosunBg.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
#header {
    height : 150px;
    background-color : #e5e3e1;
    display: flex;
    justify-content: flex-start;
    padding : 15px;
}
#mypage {
    margin-left : 700px;
}

</style>
