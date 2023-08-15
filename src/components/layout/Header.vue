<template>
    <div id="header">
        <img id="titleLogo" @click='goHome'  src="../../assets/kosletter.png"/>
        <div id="mypage">
            <h5 id='username' @click='goAbout'> {{username}} Admin</h5>
            <div id="coin">
                <h5>220코인</h5>
                <b-button>코인 사용하기</b-button>
            </div>
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
    height : 15%;
    width: 100%;
    border-radius: 5px 5px 0 0;
    background-color : #e5e3e1;
    display: flex;
    justify-content: flex-start;
    padding : 15px;
}
#mypage {
    margin-left : 700px;
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

</style>
