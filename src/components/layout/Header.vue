<template>
    <div id="header">
        <img id="titleLogo" @click='goHome'  src="../../assets/kosletter.png"/>
        <div id="mypage">
            <h5 id='username' @click='goAbout'> {{username}} </h5>
            <div id="coin">
                <h6>220코인</h6>
                <b-button id="coinUse">코인 사용하기</b-button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name : "header",
    data()  {
        return {
            isHome : true,
            username : ""
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
    created() {
        this.username = JSON.parse(sessionStorage.getItem('username'));
    }
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
    height : 15%;
    width: 100%;
    border-radius: 5px 5px 0 0;
    background-color : #e5e3e1;
    display: flex;
    justify-content: flex-start;
    padding : 15px;
}
#mypage {
    width: 20%;
    margin-left: auto; /* 아이템을 오른쪽으로 밀어내기 위해 auto 마진 사용 */
    display: flex;
    align-items: center; /* 수직 가운데 정렬 */
}
#username {
    margin-right: 20px; /* h3 텍스트와 코인 박스 사이의 간격 조정 */
}
#coin {
    align-items: center; /* 수직 가운데 정렬 */
}
#coinUse    {
    height: 30px;
    font-size: 12px;
    text-align: center;
}
</style>
