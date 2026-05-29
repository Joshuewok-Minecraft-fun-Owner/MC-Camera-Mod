import { defineConfig } from 'astro/config';

// For GitHub Pages: use 'https://yourusername.github.io/MC-Camera-Mod/'
// For Cloudflare Pages: use 'https://yourdomain.com/'
// For custom domain: use 'https://camera.minecraftfun.com/'

const SITE_URL = process.env.SITE_URL || 'https://yourusername.github.io/MC-Camera-Mod/';
const BASE_PATH = new URL(SITE_URL).pathname || '/';

export default defineConfig({
  site: SITE_URL,
  base: BASE_PATH,
  integrations: [],
  build: {
    format: 'directory'
  },
  vite: {
    ssr: {
      external: ['@astrojs/react']
    }
  }
});
