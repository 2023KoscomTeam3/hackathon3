<template>
    <div id="header">
        <div id="mypage">
            <a href="http://localhost:8080/about">
                <h2>닉네임</h2>
            </a>
            <h3>220코인</h3>
            <b-button>코인 사용하기</b-button>
        </div>
    </div>
</template>

<script>
export default {
    name : "header",
};
</script>

<style>
#header {
    height : 150px;
    background-color : #e5e3e1;
    display: flex;
    justify-content: flex-end;
    padding : 10px;
}
</style>
