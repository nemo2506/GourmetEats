# 🍪 Accessible Android App – Scrum Project

## 📌 Contexte du projet
Notre équipe de 5 personnes travaille en mode **Agile (Scrum)**.  
L’accessibilité est désormais intégrée dans notre **Definition of Done** au même titre que la documentation et les tests.  

Ce projet consiste à développer et vérifier l’accessibilité de plusieurs composants Android utilisés dans différentes activités de l’application :  

- **Case1Activity** → Ajouter un produit au panier  
- **Case2Activity** → Carte de recette avec interactions  
- **Case3Activity** → Champ de saisie du pseudonyme  

Nous mettons en pratique les recommandations issues de la conférence [*Android Makers 2022 – L’accessibilité c’est pas sorcier*](https://androidmakers.fr/) ainsi que les guidelines Google et WCAG.

---

## 🚀 Étapes de test d’accessibilité

### Outils nécessaires
- [TalkBack – Android Screen Reader](https://support.google.com/accessibility/android/answer/6007100)
- [Accessibility Scanner](https://play.google.com/store/apps/details?id=com.google.android.apps.accessibility.auditor)
- Un appareil Android physique ou un émulateur configuré pour TalkBack
- Connaissance des réglages Android (taille de police, zoom)

### Méthodologie
1. **Tester manuellement avec TalkBack**  
   → Navigation, feedback vocal, gestes nécessaires  
2. **Modifier la taille de police dans les réglages**  
   → Vérifier adaptation des textes avec `sp`  
3. **Scanner automatiquement avec Accessibility Scanner**  
   → Détection des contrastes et tailles minimales  
4. **Documenter les anomalies**  
   → Reporter sous forme de tâches dans les user stories associées  
5. **Corriger et re-tester**  
   → Vérifier que les correctifs répondent aux critères WCAG / RGAA  

---

## ✅ Problématiques détectées et corrigées

### Case1Activity – Ajouter un produit au panier
- Boutons ➕ et ➖ sans libellé → ajout d’alternatives textuelles  
- Textes définis en `px` → conversion en `sp`  
- Contraste du texte quantité insuffisant → ajustement couleurs  
- Absence de retour vocal sur changement de quantité → ajout d’annonce TalkBack  

---

### Case2Activity – Carte recette
- Image de cookie marron sur fond marron → remplacement par une image plus contrastée  
- 3 gestes nécessaires pour parcourir la carte → optimisation avec `AccessibilityActions`  
- Bouton favoris → annonce dynamique “Ajouter aux favoris” / “Retirer des favoris”  
- Pas de texte alternatif pour l’image de recette (évité car redondant avec le titre)  

---

### Case3Activity – Champ pseudonyme
**Côté code**  
- Ajout de `labelFor` pour associer le texte au champ  
- Hauteur du champ fixée à ≥ 48dp  
- Ajout de `autofillHints` pour aider la saisie assistée  

**Côté design (RGAA)**  
- La validité ne doit pas être signalée uniquement par la couleur  
- Proposer une suggestion en cas d’erreur de saisie  

---

## 📂 Ressources utiles
- [Google Accessibility Guidelines](https://developer.android.com/guide/topics/ui/accessibility?hl=fr)
- [WCAG – Web Content Accessibility Guidelines](https://www.w3.org/WAI/standards-guidelines/wcag/)
- [RGAA – Référentiel Général d’Amélioration de l’Accessibilité](https://accessibilite.numerique.gouv.fr/)
- [Material Design – Text Fields](https://m3.material.io/components/text-fields/overview)

---

## 🔎 Auto-évaluation
À la fin de l’exercice, chaque membre de l’équipe doit remplir la grille d’auto-évaluation afin de répondre aux questions :
- Quelles tâches ai-je réalisées ?
- Qu’ai-je appris à faire ?
- Quelles difficultés rencontrées ?
- Quels points d’amélioration pour la suite ?

---

## 🧑‍💻 Auteurs
Projet réalisé par une équipe Scrum de 5 personnes dans le cadre d’un exercice sur l’accessibilité Android.  

---
