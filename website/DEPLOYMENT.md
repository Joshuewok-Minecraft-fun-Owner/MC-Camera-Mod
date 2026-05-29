# Deployment Guide

Deploy the Camera Mod website to **GitHub Pages** or **Cloudflare Pages**.

## 🚀 Deployment Options

### Option 1: GitHub Pages (Free)

Deploy directly from your GitHub repository with auto-updates on push.

#### Setup

1. **Configure environment**
   
   Update `.env` with your GitHub Pages URL:
   ```env
   SITE_URL=https://Joshuewok-Minecraft-fun-Owner.github.io/MC-Camera-Mod/
   ```

2. **Update astro.config.mjs** (already configured)
   
   The config automatically detects the base path from SITE_URL.

3. **Test locally**
   ```bash
   npm run build
   npm run preview
   ```

4. **Push to GitHub**
   ```bash
   git add .
   git commit -m "Add Camera Mod website"
   git push
   ```

5. **Enable GitHub Pages in repository settings**
   - Go to Settings → Pages
   - Source: Deploy from a branch
   - Branch: `main` → `/root` (or `/docs` if you use the `docs` folder)
   - OR deploy using GitHub Actions (recommended)

#### Automated Deploy with GitHub Actions

Create `.github/workflows/deploy.yml`:

```yaml
name: Deploy to GitHub Pages

on:
  push:
    branches:
      - main

jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      
      - name: Use Node.js
        uses: actions/setup-node@v3
        with:
          node-version: '18'
      
      - name: Install dependencies
        run: |
          cd website
          npm install
      
      - name: Build
        env:
          SITE_URL: https://Joshuewok-Minecraft-fun-Owner.github.io/MC-Camera-Mod/
        run: |
          cd website
          npm run build
      
      - name: Deploy
        uses: peaceiris/actions-gh-pages@v3
        with:
          github_token: ${{ secrets.GITHUB_TOKEN }}
          publish_dir: ./website/dist
          cname: camera.minecraftfun.com  # Optional: custom domain
```

With this workflow:
- Push to `main` → automatically builds and deploys
- No manual steps needed
- Site updates in ~2 minutes

#### Custom Domain (Optional)

1. Add domain to `cname` in GitHub Actions workflow above
2. Point DNS to:
   ```
   Type: CNAME
   Name: camera
   Value: Joshuewok-Minecraft-fun-Owner.github.io
   ```
3. Verify domain in GitHub Pages settings

### Option 2: Cloudflare Pages

Fastest performance with edge caching.

#### Setup

1. **Configure environment**
   
   Update `.env` for your domain:
   ```env
   SITE_URL=https://camera.minecraftfun.com/
   ```

2. **Push to GitHub** (Cloudflare connects to your repo)
   ```bash
   git push
   ```

3. **Connect to Cloudflare Pages**
   - Go to [dash.cloudflare.com](https://dash.cloudflare.com)
   - Pages → Create a project
   - Select GitHub repository
   - Framework preset: Astro
   - Build command: `cd website && npm install && npm run build`
   - Build output directory: `website/dist`
   - Environment variable: `SITE_URL=https://camera.minecraftfun.com/`

4. **Deploy**
   - Click "Save and Deploy"
   - Cloudflare automatically builds and deploys

#### Auto-Deploy

Every push to `main` automatically triggers a new build and deployment.

#### Custom Domain

1. In Cloudflare Pages settings → Custom domain
2. Add your domain
3. Update DNS records in your Cloudflare dashboard

## 📋 Pre-Deployment Checklist

- [ ] All download links are correct and functional
- [ ] Contact/support links are updated
- [ ] Discord/GitHub/social links are correct
- [ ] Site URL in `astro.config.mjs` is updated
- [ ] Test site locally with `npm run dev`
- [ ] Run `npm run build` and check `dist/` folder
- [ ] All internal links work correctly
- [ ] Mobile responsiveness is tested

## 🔧 Environment Variables

Create `.env` file (copy from `.env.example`):

```env
SITE_URL=https://yourdomain.com
SITE_NAME=Minecraft Fun!
SITE_DESCRIPTION=Professional mods for Minecraft
```

## 📊 Post-Deployment

1. **Monitor Performance**
   - Use Google PageSpeed Insights
   - Check Core Web Vitals
   - Monitor downtime with UptimeRobot

2. **Analytics**
   - Add Google Analytics
   - Track visitor behavior
   - Monitor download clicks

3. **SEO**
   - Verify in Google Search Console
   - Set up XML sitemap
   - Monitor search rankings

## 🔄 Continuous Deployment

Most platforms support auto-deploy on push:

1. **Edit files** in your repo
2. **Commit and push** to GitHub
3. **Website auto-deploys** in seconds

No manual deployment needed after initial setup!

## 🆘 Troubleshooting

### Build fails on deployment

- Ensure all dependencies are in `package.json`
- Check Node version (use 16+)
- Run `npm run build` locally first

### Pages not loading

- Check `dist/` folder exists
- Verify build output path
- Check trailing slashes in URLs

### Styles/Assets missing

- Ensure CSS is building correctly
- Check file paths don't use absolute paths
- Verify static assets are in `public/`

## 📞 Support

For Astro-specific issues, see [Astro Deployment Docs](https://docs.astro.build/en/guides/deploy/)
