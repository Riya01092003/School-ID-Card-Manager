
const express=require("express");
const app = express();
const path=require("path");
//console.dir(app);
let port =8080;

// use ejs


app.use(express.static(path.join(__dirname,"public/css")));
app.use(express.static(path.join(__dirname,"public/js")));
app.set("view engine", "ejs");
app.set("views", path.join(__dirname, "/views"))
// app.set(express.static( path.join(__dirname, 'public')));
// app.use(express.static('private'));
// app.use(express.static( path.join(__dirname, 'private')));
app.listen(port, () =>{
    console.log(`app is listening on port ${port}`);
});
app.get("/",(req,res)=>{
    console.log("request received" );
    //res.send("you contracted root path")
    res.render("home.ejs");
});
app.post("/:riyagarg@gmail.com/:1234",(req,res)=>{  //for seprate path use get
    console.log("request received" );
    res.render("form.ejs");
});


// variable path
app.get("/:username/:id", (req,res)=>{  //for seprate path use get
    console.log(req.params);
    let {username,id}=req.params;
    let htmlC=`<h1>Welcome  @${username} your id is ${id}</h1> `
    res.send(htmlC);
});
app.get("/search", (req,res)=>{  //for seprate path use get
   console.log(req.query);
    let {q}=req.query;
    let htmlC=`<h1>Welcome your q is ${q}</h1> `
    res.send(htmlC); 
});