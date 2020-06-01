<template>
  <div v-if="!loading" class="content">
    <section>
      <label>Summary:</label>
      <p>
        This application provides a secure way to share secrets over the
        internet. It makes use of Advanced Encryption Standard (AES) via the
        <a href="https://github.com/brix/crypto-js">Crypto JS</a> library to
        encrypt secrets. Ciphers are temporarily cached; once the cipher is
        retrieved, it expires and can never be retrieved again. Hope you enjoy!
      </p>
    </section>
    <section>
      <label>Repository:</label>
      <a href="https://github.com/lipsotiko/SecretKeeper"
        >https://github.com/lipsotiko/SecretKeeper</a
      >
    </section>
    <section>
      <label>Commit:</label>
      <span>{{ herokuWebhookPayload.data.slug.commit }}</span>
    </section>
    <section>
      <label>Author:</label>
      <span>{{ herokuWebhookPayload.data.user.email }}</span>
    </section>
  </div>
</template>
<style scoped>
.content {
  display: inline-block;
  text-align: left;
  width: 412px;
}

label {
  font-weight: bold;
  margin-right: 12px;
}

section {
  margin-bottom: 12px;
}
</style>
<script>
import axios from 'axios'

export default {
  name: 'About',
  data: () => ({
    loading: true,
    herokuWebhookPayload: null
  }),
  async created () {
    this.herokuWebhookPayload = await axios
      .get('/api/webhook/read')
      .then(response => response.data)
    this.loading = false
  }
}
</script>
