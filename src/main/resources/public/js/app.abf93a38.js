(function(e){function t(t){for(var n,c,i=t[0],u=t[1],s=t[2],p=0,d=[];p<i.length;p++)c=i[p],Object.prototype.hasOwnProperty.call(o,c)&&o[c]&&d.push(o[c][0]),o[c]=0;for(n in u)Object.prototype.hasOwnProperty.call(u,n)&&(e[n]=u[n]);l&&l(t);while(d.length)d.shift()();return a.push.apply(a,s||[]),r()}function r(){for(var e,t=0;t<a.length;t++){for(var r=a[t],n=!0,i=1;i<r.length;i++){var u=r[i];0!==o[u]&&(n=!1)}n&&(a.splice(t--,1),e=c(c.s=r[0]))}return e}var n={},o={app:0},a=[];function c(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,c),r.l=!0,r.exports}c.m=e,c.c=n,c.d=function(e,t,r){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(c.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)c.d(r,n,function(t){return e[t]}.bind(null,n));return r},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],u=i.push.bind(i);i.push=t,i=i.slice();for(var s=0;s<i.length;s++)t(i[s]);var l=u;a.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},"0d03":function(e,t,r){},1:function(e,t){},10:function(e,t){},11:function(e,t){},12:function(e,t){},13:function(e,t){},14:function(e,t){},1402:function(e,t,r){"use strict";var n=r("0d03"),o=r.n(n);o.a},15:function(e,t){},2:function(e,t){},3:function(e,t){},4:function(e,t){},4437:function(e,t,r){},5:function(e,t){},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("a026"),o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("div",{attrs:{id:"nav"}},[r("router-link",{attrs:{to:"/"}},[e._v("Home")]),e._v(" | "),r("router-link",{attrs:{to:"/about"}},[e._v("About")])],1),r("router-view")],1)},a=[],c=(r("5c0b"),r("2877")),i={},u=Object(c["a"])(i,o,a,!1,null,null,null),s=u.exports,l=r("8c4f"),p=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("div",[r("textarea",{directives:[{name:"model",rawName:"v-model",value:e.secret,expression:"secret"}],attrs:{cols:"100",placeholder:"Input a secret you would like to share..."},domProps:{value:e.secret},on:{input:function(t){t.target.composing||(e.secret=t.target.value)}}}),e._v(" "),r("div",[r("button",{on:{click:e.encrypt}},[e._v("Create Shareable Link")]),r("button",{on:{click:e.reset}},[e._v("Reset")])])]),r("dialog",{ref:"dialog"},[!e.loading&&e.shortDecryptUrl?r("div",[r("input",{directives:[{name:"model",rawName:"v-model",value:e.shortDecryptUrl,expression:"shortDecryptUrl"}],ref:"decrypt-url",domProps:{value:e.shortDecryptUrl},on:{input:function(t){t.target.composing||(e.shortDecryptUrl=t.target.value)}}}),r("button",{on:{click:e.copy}},[e._v("Copy")]),r("button",{on:{click:e.reset}},[e._v("Close")])]):e._e(),e.loading?r("span",[e._v("loading...")]):e._e()])])},d=[],f=(r("d3b7"),r("25f0"),r("9911"),r("96cf"),r("1da1")),v=r("3452"),h=r.n(v),m=r("ec26"),b=r("bc3a"),y=r.n(b),g={name:"Encrypt",data:function(){return{secret:null,shortDecryptUrl:null,loading:!1}},methods:{encrypt:function(){var e=this;return Object(f["a"])(regeneratorRuntime.mark((function t(){var r,n,o,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.$refs.dialog.showModal(),e.loading=!0,r=btoa(Object(m["a"])()),n=h.a.AES.encrypt(e.secret,r).toString(),e.secret=null,t.next=7,y.a.post("/api/cipher/save",{cipherText:n}).then((function(e){return e.data}));case 7:return o=t.sent,a=window.location.href+"r/"+o+"/k/"+r,t.next=11,y()("/api/url/shorten",{params:{longUrl:a}}).then((function(e){return e.data.link}));case 11:e.shortDecryptUrl=t.sent,e.loading=!1;case 13:case"end":return t.stop()}}),t)})))()},copy:function(){this.$refs["decrypt-url"].select(),document.execCommand("copy")},reset:function(){this.secret=null,this.shortDecryptUrl=null,this.$refs.dialog.close()}}},_=g,k=(r("1402"),Object(c["a"])(_,p,d,!1,null,null,null)),w=k.exports,x=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("textarea",{directives:[{name:"model",rawName:"v-model",value:e.secret,expression:"secret"}],attrs:{cols:"100"},domProps:{value:e.secret},on:{input:function(t){t.target.composing||(e.secret=t.target.value)}}}),e._v(" "),r("div",[r("button",{on:{click:e.reset}},[e._v("Reset")])])])},j=[],O={name:"Decrypt",data:function(){return{secret:null}},created:function(){var e=this;return Object(f["a"])(regeneratorRuntime.mark((function t(){var r,n,o,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(r=e.$route.params.guid,n=e.$route.params.key,!r||!n){t.next=7;break}return t.next=5,y.a.get("/api/cipher/read",{params:{requestGuid:r}}).then((function(e){return e.data}));case 5:o=t.sent,o?(a=h.a.AES.decrypt(o,n),e.secret=a.toString(h.a.enc.Utf8)):e.secret="The requested secret is no longer available.";case 7:case"end":return t.stop()}}),t)})))()},methods:{reset:function(){this.$router.push({name:"Encrypt"})}}},S=O,P=Object(c["a"])(S,x,j,!1,null,null,null),E=P.exports,$=function(){var e=this,t=e.$createElement,r=e._self._c||t;return e.loading?e._e():r("div",{staticClass:"content"},[e._m(0),e._m(1),r("section",[r("label",[e._v("Commit:")]),r("span",[e._v(e._s(e.herokuWebhookPayload.data.slug.commit))])]),r("section",[r("label",[e._v("Author:")]),r("span",[e._v(e._s(e.herokuWebhookPayload.data.user.email))])])])},D=[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("section",[r("label",[e._v("Summary:")]),r("p",[e._v(" This application provides a secure way to share secrets over the internet. It makes use of Advanced Encryption Standard (AES) via the "),r("a",{attrs:{href:"https://github.com/brix/crypto-js"}},[e._v("Crypto JS")]),e._v(" library to encrypt secrets. Ciphers are temporarily cached; once the cipher is retrieved, it expires and can never be retrieved again. Hope you enjoy! ")])])},function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("section",[r("label",[e._v("Repository:")]),r("a",{attrs:{href:"https://github.com/lipsotiko/SecretKeeper"}},[e._v("https://github.com/lipsotiko/SecretKeeper")])])}],U={name:"About",data:function(){return{loading:!0,herokuWebhookPayload:null}},created:function(){var e=this;return Object(f["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,y.a.get("/api/webhook/read").then((function(e){return e.data}));case 2:e.herokuWebhookPayload=t.sent,e.loading=!1;case 4:case"end":return t.stop()}}),t)})))()}},R=U,A=(r("ea34"),Object(c["a"])(R,$,D,!1,null,"5db4aeb2",null)),C=A.exports;n["a"].use(l["a"]);var T=[{path:"/",name:"Encrypt",component:w},{path:"/about",name:"About",component:C},{path:"/r/:guid/k/:key",name:"Decrypt",component:E}],M=new l["a"]({base:"/",routes:T}),W=M;n["a"].config.productionTip=!1,new n["a"]({router:W,render:function(e){return e(s)}}).$mount("#app")},"5c0b":function(e,t,r){"use strict";var n=r("9c0c"),o=r.n(n);o.a},6:function(e,t){},7:function(e,t){},8:function(e,t){},9:function(e,t){},"9c0c":function(e,t,r){},ea34:function(e,t,r){"use strict";var n=r("4437"),o=r.n(n);o.a}});
//# sourceMappingURL=app.abf93a38.js.map