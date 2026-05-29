# Minecraft Camera Mod Website

A modern, responsive website for the Minecraft Camera Mod built with Astro.

## 📁 Project Structure

```
website/
├── src/
│   ├── pages/              # Website pages (auto-routes to URLs)
│   │   ├── index.astro     # Home page
│   │   ├── features.astro  # Features showcase
│   │   ├── installation.astro
│   │   ├── docs.astro      # Full documentation
│   │   └── download.astro  # Download center
│   ├── layouts/
│   │   └── Layout.astro    # Main layout wrapper
│   ├── components/         # Reusable components
│   └── styles/
│       └── global.css      # Global styles
├── public/                 # Static assets
├── astro.config.mjs        # Astro configuration
├── package.json
└── README.md
```

## 🚀 Quick Start

### Prerequisites
- Node.js 16+ 
- npm or yarn

### Installation

1. Navigate to the website directory:
```bash
cd website
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

4. Open [http://localhost:3000](http://localhost:3000) in your browser

### Build for Production

```bash
npm run build
npm run preview
```

The built site will be in the `dist/` folder.

## 📄 Pages

- **Home** (`/`) - Landing page with features overview
- **Features** (`/features`) - Detailed feature showcase
- **Installation** (`/installation`) - Step-by-step installation guides for Java and Bedrock
- **Documentation** (`/docs`) - Complete documentation and API reference
- **Download** (`/download`) - Download center with version history

## 🎨 Customization

### Colors
Edit the CSS variables in `src/styles/global.css`:
```css
:root {
  --color-primary: #5b21b6;      /* Purple */
  --color-secondary: #ec4899;    /* Pink */
  --color-accent: #06b6d4;       /* Cyan */
}
```

### Content
Each page is an Astro component located in `src/pages/`. Edit them directly to update content.

### Logo & Branding
- Update the logo in `src/layouts/Layout.astro` (currently uses emoji 📷)
- Add favicon to `public/favicon.ico`

## 🔧 Technologies

- **Astro** - Static site builder
- **CSS3** - Styling with CSS variables and Grid/Flexbox
- **JavaScript** - Interactive elements (e.g., tab switching)

## 📱 Responsive Design

The website is fully responsive and includes breakpoints for:
- Desktop (1200px+)
- Tablet (768px - 1199px)
- Mobile (<768px)

## 🚀 Deployment

### Vercel
1. Push to GitHub
2. Connect to Vercel
3. Set build command: `npm run build`
4. Set output directory: `dist`

### Netlify
1. Push to GitHub
2. Connect to Netlify
3. Set build command: `npm run build`
4. Set publish directory: `dist`

### Self-hosted
Build the site and upload the `dist/` folder to your server.

## 📖 Astro Docs

- [Astro Documentation](https://docs.astro.build)
- [Astro Integrations](https://astro.build/integrations)

## 📝 License

This website is part of the Minecraft Camera Mod project.

## 🤝 Contributing

To contribute to the website, edit the pages in `src/pages/` or create new components in `src/components/`.

## 📞 Support

For issues or questions about the website, open an issue on GitHub or check the documentation.
