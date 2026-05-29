# GitHub Pages vs Cloudflare Pages

Quick comparison and setup guide for your Camera Mod website.

## 📊 Comparison

| Feature | GitHub Pages | Cloudflare Pages |
|---------|-------------|-----------------|
| **Cost** | Free | Free (with paid Cloudflare) |
| **Setup time** | 5 minutes | 5 minutes |
| **Performance** | Good | Excellent (global CDN) |
| **Build time** | ~3 minutes | ~1 minute |
| **Custom domain** | Yes | Yes |
| **SSL/HTTPS** | Yes | Yes |
| **Analytics** | None | Cloudflare Analytics |

## 🚀 Quick Setup

### GitHub Pages (Free & Simple)

```bash
# 1. Configure environment
echo "SITE_URL=https://Joshuewok-Minecraft-fun-Owner.github.io/MC-Camera-Mod/" > website/.env

# 2. Push to GitHub
git add .
git commit -m "Add Camera Mod website"
git push

# 3. Workflow deploys automatically
# Check deployment status: Settings → Pages → Deployments
```

**Result:** Site available at `https://Joshuewok-Minecraft-fun-Owner.github.io/MC-Camera-Mod/`

### Cloudflare Pages (Faster CDN)

```bash
# 1. Configure environment
echo "SITE_URL=https://camera.minecraftfun.com/" > website/.env

# 2. Connect to Cloudflare
# - Go to dash.cloudflare.com → Pages
# - Create project → Select GitHub repo
# - Build command: cd website && npm install && npm run build
# - Output: website/dist
# - Env var: SITE_URL=https://camera.minecraftfun.com/

# 3. Push triggers automatic deployment
git push
```

**Result:** Site available at your custom domain with global CDN

## 🔧 Switching Between Hosts

### From GitHub Pages to Cloudflare

1. Update `.env`:
   ```env
   SITE_URL=https://camera.minecraftfun.com/
   ```

2. Connect repo to Cloudflare Pages

3. Push to GitHub

### From Cloudflare back to GitHub

1. Update `.env`:
   ```env
   SITE_URL=https://Joshuewok-Minecraft-fun-Owner.github.io/MC-Camera-Mod/
   ```

2. Push to GitHub (workflow deploys automatically)

## 💡 Recommendations

**Use GitHub Pages if:**
- ✓ You want zero cost
- ✓ You don't need advanced analytics
- ✓ You're just starting out

**Use Cloudflare Pages if:**
- ✓ You already use Cloudflare for DNS
- ✓ You want faster global performance
- ✓ You want built-in analytics
- ✓ You plan to scale to multiple mods

## 🌍 With Custom Domains

Both support custom domains equally well.

**Example: `camera.minecraftfun.com`**

GitHub Pages:
- DNS: CNAME → `Joshuewok-Minecraft-fun-Owner.github.io`
- Verify in GitHub Pages settings

Cloudflare Pages:
- DNS: Already in Cloudflare
- Just add domain in Pages → Settings

## 📈 Future: Multiple Mods

When you add more mods (Physics Mod, Shader Mod, etc.):

**GitHub Pages:**
- Each in separate repo
- Each gets: `https://Joshuewok-Minecraft-fun-Owner.github.io/Physics-Mod/`

**Cloudflare Pages:**
- Each in separate repo  
- Each gets: `https://physics.minecraftfun.com/` (easier with subdomains!)

## 🚀 Deployment Files Included

- `.github/workflows/deploy.yml` - GitHub Actions workflow for GitHub Pages
- `website/CLOUDFLARE.md` - Cloudflare Pages setup guide
- `website/DEPLOYMENT.md` - Full deployment documentation
