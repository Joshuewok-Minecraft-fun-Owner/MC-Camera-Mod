# Cloudflare Pages Configuration

This configuration is for deploying to Cloudflare Pages.

## Build Settings

- **Build command:** `cd website && npm install && npm run build`
- **Build output directory:** `website/dist`

## Environment Variables

Add the following in Cloudflare Pages settings:

```
SITE_URL=https://camera.minecraftfun.com/
```

(Or whatever your custom domain is)

## Deployment

1. Connect your GitHub repository to Cloudflare Pages
2. Cloudflare will automatically detect the build settings
3. Every push to `main` branch will trigger a deployment
4. Monitor deployments in Cloudflare Pages dashboard

## Custom Domain

1. In Pages → Settings → Custom domain
2. Add your domain
3. Update DNS records in Cloudflare
