<template>
    <div>
        <div id="padding"> </div>
        <div id="cardTitleBox">
            <h1 id="cardTitleText">MY STOCK</h1>
        </div>
        <div class="box">
            <div class="c"> 
                <div class="stockPhoto" id="p1">

                </div>
                <div id="stockText">
                    LG 에너지 솔루션
                </div>
                <b-button>삭제</b-button>
            </div>
            <div class="c"> 
                <div class="stockPhoto" id="p2">

                </div>
                <div id="stockText">
                    SK하이닉스
                </div>
                <b-button>삭제</b-button>
            </div>
            <div class="c"> 
                <div class="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
        </div>
        <div class="box">
            <div class="c"> 
                <div class="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
            <div class="c"> 
                <div class="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
            <div class="c"> 
                <div class="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name : "card",
    method : {

    },
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
    #myCard {
        height: 200px;
    }
    #cardTitleBox {
        height : 50px;
        padding-top : 20px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    #padding {
        height: 10px;
    }
    #stockText {
        margin-top: 5px;
        margin-bottom: 5px;
        height: 50px;
        text-align: center;
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
    }
    #c {
        height :100;
        background-color : #2c3e50
    }
    .stockPhoto {
        background-color: white;
        height: 50%;
        background-repeat: no-repeat;
        background-size: contain; 
        background-position: center; 
    }
    #p1 {
        background-image: url('../../assets/logo/LG.png');
    }
    #p2 {
        background-image: url('../../assets/logo/sk-hynix.png');
    }
</style>