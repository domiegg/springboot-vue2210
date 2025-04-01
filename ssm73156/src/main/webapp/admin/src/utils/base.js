const base = {
    get() {
                return {
            url : "http://localhost:8080/ssm73156/",
            name: "ssm73156",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm73156/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "新能源汽车在线租赁"
        } 
    }
}
export default base
