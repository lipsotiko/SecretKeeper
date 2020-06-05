<template>
  <div class="container">
    <div>
      <div class="toolbar">
        <input type="file" ref="secret-file" @change="fileSelected" />
        <div>
          <button @click="createShareableLink">Create Shareable Link</button>
          <button @click="reset">Reset</button>
        </div>
      </div>
      <textarea
        v-model="secret"
        placeholder="What's your secret...?"
        v-if="!fileName"
      />
      <div></div>
    </div>
    <dialog ref="dialog">
      <div v-if="!creating && shortUrl">
        <input v-model="shortUrl" ref="decrypt-url" />
        <button @click="copy">Copy</button>
        <button @click="reset">Close</button>
      </div>
      <span v-if="creating">creating...</span>
    </dialog>
  </div>
</template>

<script>
import CryptoJS from 'crypto-js'
import { v4 as uuidv4 } from 'uuid'
import axios from 'axios'

export default {
  name: 'Encrypt',
  data: () => ({
    secret: null,
    shortUrl: null,
    creating: false,
    fileName: null
  }),
  methods: {
    async createShareableLink () {
      if (this.secret) {
        this.creating = true
        this.$refs.dialog.showModal()
        const { cipher, key } = this.createKeyAndCipher(this.secret)
        this.secret = null
        const requestId = await this.saveCipher(cipher)
        const longUrl = this.buildUrl(requestId, key, this.fileName)
        this.shortUrl = await this.shortenUrl(longUrl)
        this.creating = false
      }
    },
    copy () {
      this.$refs['decrypt-url'].select()
      document.execCommand('copy')
    },
    reset () {
      this.$refs.dialog.close()
      this.secret = null
      this.shortUrl = null
      this.fileName = null
      this.$refs['secret-file'].value = null
    },
    fileSelected (e) {
      const blob = e.target.files[0]
      this.fileName = blob.name
      const reader = new FileReader()
      reader.addEventListener(
        'load',
        () => {
          this.secret = reader.result
        },
        false
      )
      reader.readAsBinaryString(blob)
    },
    createKeyAndCipher (secret) {
      const key = btoa(uuidv4())
      const cipher = CryptoJS.AES.encrypt(secret, key).toString()
      return { cipher, key }
    },
    async saveCipher (cipher) {
      return await axios
        .post('/api/cipher/save', {
          cipher
        })
        .then(response => response.data)
    },
    buildUrl (requestId, key, fileName) {
      let longUrl =
        window.location.href + 'r/' + requestId + '/k/' + key + '/f/'
      if (fileName) {
        longUrl += encodeURIComponent(fileName)
      } else {
        longUrl += 'text'
      }
      return longUrl
    },
    async shortenUrl (longUrl) {
      return await axios('/api/url/shorten', {
        params: {
          longUrl
        }
      }).then(response => response.data.link)
    }
  }
}
</script>
<style>
.toolbar {
  display: flex;
  justify-content: space-between;
}

input {
  margin: 6px;
}

dialog {
  border-radius: 5px;
  border: 1px solid black;
  text-align: center;
}

dialog + .backdrop {
  background-color: rgba(0, 0, 0, 0.4);
}
</style>
