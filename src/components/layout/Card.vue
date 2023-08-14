<template>
    <div>
        <div id="padding"> </div>
        <h1>MY STOCK</h1>
        <div class="box">
            <div class="c"> 
                <div id="stockPhoto">
                    <img id="photo" v-if = 'dynamicText[0]' :src="dynamicText[0].logo"/>
                </div>
                <div id="stockText">
                    <h5 id="stName" v-if = 'dynamicText[0]'>{{dynamicText[0].name}}</h5>
                    <!-- <h5 id="stName">LG에너지솔루션</h5> -->
                </div>
            </div>
            <div class="c"> 
                <div id="stockPhoto">
                    <img id="photo" v-if = 'dynamicText[1]' :src="dynamicText[1].logo" />
                    <!-- <img id="photo" src="../../assets/logo/sk-hynix.png"/> -->
                </div>
                <div id="stockText">
                    <h5 id="stName" v-if = 'dynamicText[1]'>{{dynamicText[1].name}}</h5>
                    <!-- <h5 id="stName">SK하이닉스</h5> -->
                </div>
            </div>
            <div class="c"> 
                <div id="stockPhoto">
                    <img id="photo" v-if = 'dynamicText[2]' :src="dynamicText[2].logo" />
                </div>
                <div id="stockText">
                    <h5 id="stName" v-if = 'dynamicText[2]'>{{dynamicText[2].name}}</h5>
                </div>
            </div>
        </div>

        <div class="box">
            <div class="c"> 
                <div id="stockPhoto">
                    <img id="photo" v-if = 'dynamicText[3]' :src="dynamicText[3].logo" />
                </div>
                <div id="stockText">
                    <h5 id="stName" v-if = 'dynamicText[3]'>{{dynamicText[3].name}}</h5>
                </div>
            </div>
            <div class="c"> 
                <div id="stockPhoto">
                    <img id="photo" v-if = 'dynamicText[4]' :src="dynamicText[4].logo" />
                </div>
                <div id="stockText">
                    <h5 id="stName" v-if = 'dynamicText[4]'>{{dynamicText[4].name}}</h5>
                </div>
            </div>
            <div class="c"> 
                <div id="stockPhoto">
                    <img id="photo" v-if = 'dynamicText[5]' :src="dynamicText[5].logo" />
                </div>
                <div id="stockText">
                    <h5 id="stName" v-if = 'dynamicText[5]'>{{dynamicText[5].name}}</h5>
                </div>
            </div>
        </div>
        <div id="btnBox">
            <b-button class="delete-b"> 업데이트 </b-button>
            <b-button class="delete-b"  @click="resetStock">리셋</b-button>
        </div>
    </div>
</template>



<script>
import Vue from 'vue';

export default {
    name : "card",
    data()  {
        return {
            stack : 0,
            dynamicText : [false,false,false,false,false,false]
        }
    },
    methods : {
        resetStock() {
        // 해당 인덱스의 dynamicText 요소 초기화 (null 또는 원하는 초기값으로 설정 가능)
        for (var i=0; i<6; i++) {
            this.$set(this.dynamicText, i, false);
        }
        // 변경된 dynamicText 데이터 세션 스토리지에 저장
        this.stack = 0;
        sessionStorage.setItem("dynamicText", JSON.stringify(this.dynamicText));
        },
        adjustImageSize(event) {
            const img = event.target;
            const container = img.parentNode;
            container.style.height = img.clientHeight + "px";
            container.style.width = img.clientWidth + "px";
        },
    },
    created()   {
        // 세션 스토리지에서 dynamicText 데이터 로드
        const storedData = sessionStorage.getItem('dynamicText');
        if (storedData) {
            this.dynamicText = JSON.parse(storedData);
            this.stack = this.dynamicText.filter(Boolean).length;
        }

        Vue.bus.$on('eventA', data => {
            console.log(data);
            console.log(data.logo);
            if (this.stack <= 5) {
                this.$set(this.dynamicText, this.stack, data);
                this.stack = this.stack + 1
                // 변경된 dynamicText 데이터 세션 스토리지에 저장
                sessionStorage.setItem('dynamicText', JSON.stringify(this.dynamicText));
            }
        });
    }
    // created() {
    //     console.log("startLoad")
    //     this.$axios.get("http://3.38.94.77/api/main/my-stock-list")
    //         .then(res => {
    //             console.log(res);
    //         })
    //         .catch(err =>   {
    //             console.log(err);
    //         })
    //     console.log("endLoad")
    // }
};
</script>

<style scoped>
    #padding {
        height: 10px;
    }
    #stockPhoto {
        background-color: white;
        height: 70%;
        overflow: hidden; 
        display: flex;
        align-items: center;
        justify-content: center;
        overflow: hidden;
        /* display: flex;
    align-items: center;
    justify-content: center; */
    }
    #stockText {
        background-color: grey;
        margin-top: 5px;
        margin-bottom: 5px;
        height: 27%;
        display: flex;
        align-items: center;
        justify-content: center;
        
    }
    .box {
        margin-top : 20px;
        margin-left : 10px;
        margin-right : 10px;
        margin-bottom : 30px;
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        align-items: stretch;
        flex: 1;
    }
    .c {
        width : 33%;
        flex: 1;
        box-sizing: border-box;
        background-color : #F4F2EB;
        margin-left : 10px;
        margin-right : 10px;
        height: 200px;
        padding-top: 5px;
        padding-bottom: 5px;
        padding-left: 5px;
        padding-right: 5px;
        border-radius: 10px;
        
    }
    #c {
        height :100;
        background-color : #2c3e50
    }
    .delete-b{
        background-color : #ED6C1D;
        width: 100px;
        margin-left : 20px;
    }
    #photo {
    /* width: 50px;
    height: 50px; */
    max-width: 100%;
    max-height: 100%;
    object-fit: cover;
    }
    #stName {
        color: #F4F2EB; /* 변경하고자 하는 글자 색상 */
    }
    #btnBox {
    }
</style>