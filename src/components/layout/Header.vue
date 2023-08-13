<template>
    <div id="header">
        <h1>KosLetter</h1>
        <div id="mypage">
            <a href="http://localhost:8080/about">
                <h2>{{username}}1111</h2>
            </a>
            <h3>220코인</h3>
            <b-button>코인 사용하기</b-button>
        </div>
    </div>
</template>

<script>
export default {
    name : "header",
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
#header {
    height : 150px;
    background-color : #e5e3e1;
    display: flex;
    justify-content: flex-end;
    padding : 10px;
}
</style>
