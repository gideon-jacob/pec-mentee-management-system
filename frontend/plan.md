```
.
├── agent-docs/
│   └── ui_description.json
├── public/
│   ├── manifest.webmanifest
│   └── icons/
│       ├── icon-72x72.png
│       ├── icon-96x96.png
│       ├── icon-128x128.png
│       ├── icon-144x144.png
│       ├── icon-192x192.png
│       └── icon-512x512.png
├── src/
│   ├── main.tsx
│   ├── index.css
│   ├── assets/
│   │   ├── pec_logo.png
│   │   ├── splash-icon.png
│   │   └── placeholders.json
│   ├── pages/
│   │   ├── RoleSelectionPage/
│   │   │   ├── RoleSelectionPage.tsx
│   │   │   └── RoleCard.tsx
│   │   └── LoginPage/
│   │       └── LoginPage.tsx
│   ├── layouts/
│   │   └── AuthenticatedLayout/
│   │       └── AuthenticatedLayout.tsx
│   ├── components/
│   │   ├── Header/
│   │   │   ├── Header.tsx
│   │   │   └── Logo.tsx
│   │   ├── AvatarDropdown/
│   │   │   └── AvatarDropdown.tsx
│   │   ├── DropdownMenu/
│   │   │   └── DropdownMenu.tsx
│   │   ├── Sidebar/
│   │   │   └── CollapsibleSidebar.tsx
│   │   ├── Navigation/
│   │   │   └── NavigationMenu.tsx
│   │   ├── Cards/
│   │   │   └── Card.tsx
│   │   ├── Forms/
│   │   │   ├── Input.tsx
│   │   │   └── PasswordInput.tsx
│   │   ├── Grid/
│   │   │   └── Grid.tsx
│   │   └── PWA/
│   │       └── PwaInstallPrompt.tsx
│   ├── hooks/
│   │   └── useAuth.ts
│   ├── styles/
│   │   └── tokens.css
│   └── types/
│       └── ui.d.ts
└── README.md
```

# Frontend Implementation Plan (PECTOP)
Goal: Implement the Vite + React + TypeScript frontend structure and configuration described in the UI description. This plan breaks the work into ordered milestones with concrete tasks, CLI commands, acceptance criteria, and estimated effort so we can implement features incrementally.

Assumptions
- Node >= 18 is available.
- We will use Vite (React + TS + SWC), TailwindCSS, Zustand, Zod, idb-keyval, vite-plugin-pwa (workbox), and testing with Vitest + Testing Library.
- Backend endpoints are mocked initially (or proxied via VITE_API_BASE_URL).
- agent-docs/ui_description.json is the authoritative UI spec.

Milestones (ordered)

1. Repo & base initialization (1–2 hours)
   - Summary (your current state): You already created a Vite TypeScript + SWC React project using create-vite@latest and installed the runtime and dev packages. The remaining initialization primarily covers TypeScript config checks (if missing) and Tailwind initialization and minimal config adjustments for SWC.
   - Tasks:
     - Verify Git repository and branch (git status; git checkout -b feat/init-frontend if needed).
     - Verify tsconfig files created by create-vite. If tsconfig.* files are missing, initialize TypeScript and create recommended configs.
     - Initialize TailwindCSS (postcss config + tailwind config) and add Tailwind imports to src/index.css.
     - Ensure vite.config.ts uses the SWC React plugin (@vitejs/plugin-react-swc). If create-vite already configured it, confirm any additional plugins (tsconfig-paths, vite-plugin-pwa) are added.
     - Add .gitignore, README stub, and basic public/index.html if not present.
   - CLI (run these from project root):
     1. Verify repository & branch
        - git init                     # only if repo not initialized
        - git checkout -b feat/init-frontend
     2. Verify TypeScript config (if create-vite already produced tsconfig.json you can skip)
        - [Check] ls tsconfig*.json
        - If missing:
          - npx tsc --init
          - (Optional) create tsconfig.app.json / tsconfig.node.json as per plan
     3. Initialize Tailwind (if not already present)
        - npx tailwindcss init -p
        - This will create tailwind.config.cjs and postcss.config.cjs (or .js)
     4. Confirm SWC plugin in vite.config.ts
        - If not present, install and add:
          - npm i -D @vitejs/plugin-react-swc
        - Example check: vite.config.ts should import from '@vitejs/plugin-react-swc' rather than '@vitejs/plugin-react'
     5. Add optional dev tooling (if not installed previously):
        - npm i -D tsconfig-paths vite-plugin-pwa eslint prettier vitest @testing-library/react @testing-library/jest-dom
     6. Start dev server
        - npm run dev
   - Deliverables:
     - package.json (already present if create-vite ran)
     - tsconfig.json (or generated via npx tsc --init)
     - tailwind.config.* and postcss.config.* files
     - .gitignore and README.md stub
     - vite.config.ts updated/verified for SWC and plugins
   - Acceptance criteria:
     - npm run dev starts Vite and serves the app.
     - TypeScript compilation succeeds (or tsserver runs without errors in your editor).
     - Tailwind utility classes apply when adding a test class (e.g., bg-red-500) to src/index.css and a test component.
     - vite.config.ts references @vitejs/plugin-react-swc (or create-vite's default SWC config) and optional plugins present.

2. Vite + TypeScript + path aliases + basic app shell (1–2 hours)
   - Tasks:
     - Add/verify vite.config.ts with SWC react plugin and tsconfig paths plugin.
     - Create src/main.tsx, src/index.css, public/index.html if not present.
     - Add basic App.tsx and Router skeleton.
   - CLI/Files:
     - Create vite.config.ts (if not created) or update to include plugins
     - Create src/main.tsx, src/App.tsx, src/index.css
   - Acceptance criteria: App renders at http://localhost:5173; basic route exists.

3. Tailwind + design tokens (30–60 minutes)
   - Tasks:
     - Configure tailwind.config.cjs content, import tailwind in index.css.
     - Create src/styles/tokens.css for design tokens.
   - Acceptance criteria: Tailwind utility classes render, tokens available.

4. Type definitions and folder scaffolding (30–60 minutes)
   - Tasks:
     - Create src/types/global.d.ts and src/types/ui.d.ts.
     - Create asset placeholders and ui json copies (src/assets/*.json).
     - Create folder tree per UI description (pages, components, hooks, stores, services).
   - Acceptance criteria: File tree matches provided structure; no TypeScript errors from missing types.

5. Vite Plugin PWA + manifest + service worker skeleton (1–2 hours)
   - Tasks:
     - Add public/manifest.webmanifest, icons (placeholders), and configure vite-plugin-pwa in vite.config.ts using agent-docs/ui_description.json pwaConfig.
     - Add src/services/pwa/registerServiceWorker.ts and skeleton sw.ts (or workbox config).
   - Acceptance criteria: Manifest loads; service worker registers in dev/preview; PWA metadata visible in Lighthouse.

6. Offline queue & IndexedDB adapter (2–4 hours)
   - Tasks:
     - Implement src/services/offline/indexedDbAdapter.ts using idb-keyval.
     - Implement src/components/Offline/OfflineSyncQueue.tsx and src/services/offline/queueService.ts.
     - Wire Background Sync message contract in sw.ts.
   - Acceptance criteria: Queue items can be persisted and read from IndexedDB; service worker message interface documented and simulated.

7. State management (Zustand) & Auth store (1–2 hours)
   - Tasks:
     - Create src/stores/rootStore.ts and individual stores: authStore.ts, layoutStore.ts, offlineQueueStore.ts, mentorStore.ts.
     - Provide GlobalStateProvider and hooks.
   - Acceptance criteria: Stores usable via hooks; token persisted to localStorage as described.

8. API clients & HTTP wrapper with offline integration (2–4 hours)
   - Tasks:
     - Implement src/services/api/httpClient.ts that attaches auth header, retries 5xx, and enqueues offline writes.
     - Implement authClient, studentApi, mentorApi, adminApi adapters with typed requests.
   - Acceptance criteria: API call flow works against mock server; offline POST/PUT/DELETE enqueues when navigator.onLine===false.

9. Core UI components & layout (3–6 hours)
   - Tasks:
     - Implement Header (with Logo, PwaInstallPrompt), CollapsibleSidebar, NavigationMenu, AvatarDropdown, Card, Input, PasswordInput, Grid components as minimal accessible components.
     - Implement AuthenticatedLayout with header + sidebar + outlet.
   - Acceptance criteria: Layout renders pages; sidebar toggles; header displays dummy user.

10. Pages: Role selection, Login, NotFound (2–3 hours)
    - Tasks:
      - Implement RoleSelectionPage, RoleCard, LoginPage with Zod form validation and useAuth hook wiring.
    - Acceptance criteria: Navigate /, select role, go to /login/:role and validate form.

11. Additional pages & features (iterative)
    - Mentor dashboard, Student profile, Admin pages, Programs list, Help page.
    - Implement charts, tables, forms, dialogs as separate tasks (1–3 days per complex page depending on data/model complexity).
    - Acceptance criteria: Feature-specific acceptance tests per SRS_REPORT.md.

12. Testing (Vitest) & mocks (2–4 hours)
    - Tasks:
      - Add src/tests setup, sample unit tests for Header, offline queue tests, LoginPage test.
      - Configure vitest.config.ts and test scripts.
    - Acceptance criteria: Tests run in CI; core unit tests pass.

13. CI (GitHub Actions) and lint/format (1–2 hours)
    - Tasks:
      - Add .github/workflows/ci.yml with install, lint, test, build jobs.
      - Add ESLint + Prettier configs.
    - Acceptance criteria: CI passes on push; PRs run tests.

14. Docker preview & README (1–2 hours)
    - Tasks:
      - Create Dockerfile for preview, .env.example, update README with setup steps and references to SRS and ui_description.json.
    - Acceptance criteria: docker build + docker run serve preview works.

15. Iterative feature backlog and documentation
    - Tasks:
      - Map SRS_REPORT.md features to individual tickets and acceptance criteria.
      - Fill docs/ (ADR, COMPONENT_CATALOG, API_CONTRACT).
    - Acceptance criteria: Developer onboarding guide and component catalog aligned with ui_description.json.

Implementation details & CLI walkthrough (initial setup)
1. Verify repo & branch:
   - git status
   - git checkout -b feat/init-frontend
2. Handle TypeScript config:
   - ls tsconfig*.json
   - If not present:
     - npx tsc --init
3. Initialize Tailwind (if not already present):
   - npx tailwindcss init -p
   - Add Tailwind imports to src/index.css:
     - @tailwind base;
     - @tailwind components;
     - @tailwind utilities;
4. Confirm SWC plugin:
   - Open vite.config.ts and verify import from '@vitejs/plugin-react-swc'.
   - If not present, install and update:
     - npm i -D @vitejs/plugin-react-swc
5. Start dev server:
   - npm run dev
   - Open http://localhost:5173

Priorities & dependencies
- Must verify Vite + TypeScript + SWC + Tailwind before building components/pages.
- PWA + SW should be added early so that offline queue hooks can be defined and tested.
- Stores and API wrappers should be ready before complex pages to ensure consistent integration points.

Estimated overall timeline (rough)
- Minimum viable shell (steps 1–5): 1 day
- Offline, stores, API, core layout (steps 6–9): 2–3 days
- Pages and feature parity with SRS (iterative): 1–3+ weeks depending on scope and backend readiness
- Tests + CI + Docker: 1–2 days

Acceptance criteria (project-level)
- App runs under Vite and TypeScript with no compile errors.
- Tailwind is active and design tokens present.
- PWA manifest and service worker register and expose messaging hooks.
- Offline queue persists items and service worker processing contract is defined.
- Stores and API clients available with documented interfaces.
- Role selection and login flows functional with Zod validation.
- CI runs lint/test/build on push.

Notes / Next steps
- After you confirm this plan, I will proceed with milestone 1 (verify tsconfig/tailwind + vite config), and can create the file tree scaffolding shown in your previous message. Prompt me which milestone to implement next or request specific files to scaffold.