<template>
    <div>
        <Header />
        <div id="containerAbout">
            <div id="sec1">
                
            </div>
            <div id="sec2">

            </div>
            <div id="sec3">
                
            </div>
        </div>
    </div>
</template>


<script>
import Header from '../components/layout/Header.vue'

export default {
    name : 'Home',
    components: {
        Header,
    },
    data() {
        return {
            stockList : [
                {id:1, name : "삼성전자"},
                {id:2, name : "LG에너지솔루션"},
                {id:3, name : "SK하이닉스"},
                {id:4, name : "삼성바이오로직스"},
                {id:5, name : "POSCO홀딩스"},
                {id:6, name : "LG화학"},
                {id:7, name : "삼성SDI"},
                {id:8, name : "현대차"},
                {id:9, name : "NAVER"},
                {id:10, name : "포스코퓨처엠"},
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
#containerAbout {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: stretch;
    flex: 1;
}
#sec1 {
    width: 33%;
    background-color : green;
    flex : 1
}
#sec2 {
    width: 33%;
    float: right;
    padding : 10px;
    background-color: red;
}
#sec3 {
    width: 33%;
    background-color : yellow;
}
</style>
