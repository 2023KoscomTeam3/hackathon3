<template>
    <div>
        <div id="padding"> </div>
        <div class="box">
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
        </div>
        <div class="box">
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button>삭제</b-button>
            </div>
            <div class="c"> 
                <div id="stockPhoto">

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
      getData() {
        this.$axios
          .get()
      }
    }
};
</script>

<style>
    #myCard {
        height: 200px;
    }
    #section1 {
        float: left;
        box-sizing: border-box;
        background-color : green
    }
    #padding {
        height: 120px;
    }
    #stockPhoto {
        background-color: white;
        height: 80px;
    }
    #stockText {
        background-color: grey;
        margin-top: 5px;
        margin-bottom: 5px;
        height: 50px;
    }
    .box {
        margin-top : 100px;
        margin-left : 10px;
        margin-right : 10px;
        margin-bottom : 30px;
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        align-items: stretch;
        flex: 1;
        background-color: yellow;
    }
    .c {
        width : 33%;
        flex: 1;
        box-sizing: border-box;
        background-color : greenyellow;
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
</style>