<template>
    <div>
        <div id="padding"> </div>
        <div class="box">
            <div class="c"> 
                <div id="stockPhoto">
                    <img id="photo" src="../../assets/logo/LG.png"/>
                </div>
                <div id="stockText">
                    <h5 id="stName">LG에너지솔루션</h5>
                </div>
                <b-button class="delete-b">삭제</b-button>
            </div>
            <div class="c"> 
                <div id="stockPhoto">
                    <img id="photo" src="../../assets/logo/sk-hynix.png"/>
                </div>
                <div id="stockText">
                    <h5 id="stName">SK하이닉스</h5>
                </div>
                <b-button class="delete-b">삭제</b-button>
            </div>
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button class="delete-b">삭제</b-button>
            </div>
        </div>
        <div class="box">
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button class="delete-b">삭제</b-button>
            </div>
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button class="delete-b">삭제</b-button>
            </div>
            <div class="c"> 
                <div id="stockPhoto">

                </div>
                <div id="stockText">

                </div>
                <b-button class="delete-b">삭제</b-button>
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
    #padding {
        height: 10px;
    }
    #stockPhoto {
        background-color: white;
        height: 50%;
        overflow: hidden; 
        display: flex;
    align-items: center;
    justify-content: center;
    height: 50%;
    overflow: hidden;
        /* display: flex;
    align-items: center;
    justify-content: center; */
    }
    #stockText {
        background-color: grey;
        margin-top: 5px;
        margin-bottom: 5px;
        height: 50px;
        display: flex;
    align-items: center;
    justify-content: center;
        
    }
    .box {
        margin-top : 70px;
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
        background-color : #ED6C1D
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

</style>