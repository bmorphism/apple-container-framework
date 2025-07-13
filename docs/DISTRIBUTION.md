# Apple Container Framework - Distribution Guide

## 📦 Package Distribution Options

The Apple Container Framework supports multiple distribution channels for maximum accessibility and ease of integration.

---

## 🚀 Primary Distribution Channels

### 1. **Git Dependencies (Recommended)**

For the latest features and development versions:

```clojure
;; In your bb.edn or deps.edn
{:deps {io.github.bmorphism/apple-container-framework 
        {:git/url "https://github.com/bmorphism/apple-container-framework"
         :git/sha "d5438ff"}}}
```

**Advantages:**
- Always latest version
- Direct from source
- No release lag
- Easy to fork and modify

### 2. **Clojars Maven Repository**

For stable, versioned releases:

```clojure
;; In your bb.edn or deps.edn  
{:deps {io.github.bmorphism/apple-container-framework {:mvn/version "0.1.0"}}}
```

**Advantages:**
- Stable, tested releases
- Semantic versioning
- Reliable availability
- Corporate-friendly

### 3. **bbin CLI Installation**

For command-line usage and scripts:

```bash
# Install globally
bbin install io.github.bmorphism/apple-container-framework

# Use directly
apple-container-framework --help
```

**Advantages:**
- Global CLI availability
- No project dependency
- Quick experimentation
- Scriptable usage

---

## 🏗️ Package Structure

### **Standard Babashka Library Layout**

```
apple-container-framework/
├── bb.edn                    # Babashka tasks and dependencies
├── deps.edn                  # Clojure dependencies and aliases
├── build.clj                 # Build script for jar/deploy
├── VERSION                   # Version file for automation
├── src/                      # Source code
│   └── apple/
│       └── container/
│           └── core.bb       # Core protocols and implementations
├── resources/                # Templates and static resources
├── examples/                 # Usage examples
├── test/                     # Test suite
├── docs/                     # Documentation
└── .github/                  # CI/CD workflows
```

---

## 🔧 Development Workflow

### **For Library Authors**

1. **Clone and Setup**
   ```bash
   git clone https://github.com/bmorphism/apple-container-framework
   cd apple-container-framework
   bb deps  # Install dependencies
   ```

2. **Development Tasks**
   ```bash
   bb test           # Run all tests
   bb jar            # Build jar
   bb install        # Install locally
   ```

3. **Version Management**
   ```bash
   bb show-version   # Show current version
   ```

### **For End Users**

1. **Quick Start**
   ```bash
   # Create new project
   mkdir my-container-project
   cd my-container-project
   
   # Add dependency
   echo '{:deps {io.github.bmorphism/apple-container-framework {:git/url "https://github.com/bmorphism/apple-container-framework" :git/sha "latest"}}}' > bb.edn
   
   # Create script
   echo '#!/usr/bin/env bb
   (require [apple.container.core :as container])
   (container/quick-deploy "my-service" "nginx:alpine")' > deploy.bb
   
   chmod +x deploy.bb
   ./deploy.bb
   ```

---

## 🌐 Installation Methods

### **macOS (Primary Platform)**

#### Via Direct Download
```bash
curl -L https://github.com/bmorphism/apple-container-framework/releases/latest/download/apple-container-framework.jar -o apple-container-framework.jar
bb -cp apple-container-framework.jar --help
```

### **Other Platforms (Limited)**

While the framework is optimized for Apple Silicon, core functionality works on other platforms:

```bash
# Linux/Windows (limited functionality)
bbin install io.github.bmorphism/apple-container-framework --platform generic
```

**Note**: Apple-specific features (VM snapshots, hardware acceleration) require macOS.

---

## 📚 Documentation Distribution

### **Integrated Documentation**

- **README.md**: Quick start and overview
- **docs/**: Comprehensive guides
- **examples/**: Working code samples
- **CHANGELOG.md**: Version history
- **API docs**: Generated from source

### **Online Resources**

- **GitHub**: https://github.com/bmorphism/apple-container-framework
- **Clojars**: https://clojars.org/io.github.bmorphism/apple-container-framework

---

## 🚀 CI/CD and Automation

### **GitHub Actions Pipeline**

- **Testing**: Protocol compliance and integration tests
- **Linting**: Code quality and style checks
- **Building**: Jar creation and verification
- **Deployment**: Automated Clojars publishing
- **Release**: GitHub releases with artifacts

---

**The Apple Container Framework is designed for maximum accessibility while maintaining the performance and reliability that Apple Silicon demands.**