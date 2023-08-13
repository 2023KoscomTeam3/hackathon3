<template>
    <div>
        <Header />
        <div>
            <div id="section1">
                <Card />
            </div>
            <div id="section2">
                <CardRank v-bind:stockL="stockList" />
            </div>
        </div>
    </div>
</template>


<script>

import Header from '../components/layout/Header.vue'
import Card from '../components/layout/Card.vue'
import CardRank from '../components/layout/CardRank.vue'

export default {
    name : 'Home',
    components: {
        Header,
        Card,
        CardRank
    },
    data() {
        return {
            stockList : [
                {id:1, name : "삼성전자", logo : "../assets/samsung.png"},
                {id:2, name : "LG에너지솔루션", logo : "../assets/lg.png"},
                {id:3, name : "SK하이닉스", logo : "../assets/sk-hynix.png"},
                {id:4, name : "삼성바이오로직스", logo : "../assets/samsung.png"},
                {id:5, name : "POSCO홀딩스", logo : "../assets/posco.png"},
                {id:6, name : "LG화학", logo : "../assets/lg.png"},
                {id:7, name : "삼성SDI", logo : "../assets/samsung.png"},
                {id:8, name : "현대차", logo : "../assets/hyundai.png"},
                {id:9, name : "NAVER", logo : "../assets/naver.png"},
                {id:10, name : "포스코퓨처엠", logo : "../assets/posco.png"},
            ],
        };
    },
    methods : {
        getData()   {
            alert(this.input1);
        },
        setData()   {
            this.input1 = "12345"
        }
    }
};
</script>

<style>
#container {
    width: 100%;
    height: 100%;
    background-color : red
}
#section1 {
    width: 50%;
    background-color : green;
    flex : 1
}
.box {
    display: flex;
    margin-top : 30px;
    margin-left : 10px;
    margin-right : 10px;
    margin-bottom : 30px;
}
.c1 {
    flex: 1;
    box-sizing: border-box;
    background-color : greenyellow
}
.c2 {
    flex: 1;
    box-sizing: border-box;
    background-color : grey
}
.c3 {
    flex: 1;
    box-sizing: border-box;
    background-color : gold
}
#section2 {
    width: 50%;
    float: right;
    box-sizing: border-box;
    padding : 10px;
}
</style>
