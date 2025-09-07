# CLAUDE.md

# Claude AI Integration for JPA Dojo

## Overview
This JPA Dojo uses Claude AI for automated verification and assessment of student solutions. Students can get immediate, detailed feedback on their JPA implementations without waiting for instructor review.

## How Verification Works

### 1. Complete Your Exercise
- Implement the required JPA entities following the exercise instructions
- Ensure your code compiles and follows the specified requirements
- Test your implementation using the provided REST API endpoints

### 2. Prepare Your Solution for Assessment
- Copy your complete `Person.java` entity class
- Copy your complete `Car.java` entity class
- Have both files ready for submission

### 3. Get AI Verification
- Open Claude AI (claude.ai) or any compatible AI assistant
- Copy the verification prompt from [Assessment.md](./Assessment.md)
- Paste the prompt into your conversation with the AI
- Follow the prompt with your entity implementations

### 4. Submit Your Code
Format your submission like this:

```
[Paste the verification prompt from Assessment.md here]

Here are my entity implementations:

**Person.java:**
```java
[Your Person.java code here]
```

**Car.java:**
```java  
[Your Car.java code here]
```

Please verify my solution.
```

### 5. Review Feedback and Iterate
- Read the AI's detailed feedback carefully
- Pay attention to both technical corrections and business logic explanations
- Make necessary improvements to your code
- Re-submit if needed until you achieve PASS status

## What the AI Will Check

The verification process evaluates:

### ✅ Technical Correctness
- Proper JPA annotations (`@Entity`, `@Id`, `@OneToOne`, etc.)
- Correct relationship ownership and foreign key placement
- Appropriate cascade configuration
- Standard naming conventions

### 🎯 Business Logic Understanding  
- Does your ownership decision make business sense?
- Are cascade operations appropriate for the use case?
- Does your design align with the company car tracking context?

### 💡 Best Practices
- Code structure and readability
- Proper use of JPA features
- Performance considerations

## Assessment Criteria

Your solution will be marked as:
- **PASS**: Correct implementation with good understanding demonstrated
- **NEEDS WORK**: Some issues present, specific feedback provided for improvement  
- **FAIL**: Major problems requiring significant rework

## Tips for Success

1. **Read the exercise context carefully** - Understanding the business domain helps you make better technical decisions
2. **Think about ownership** - Who controls the relationship in real life?
3. **Test your cascade operations** - Make sure cars save automatically when you save persons
4. **Use Claude Code for faster feedback** - No copy-pasting required, just ask for verification
5. **Ask follow-up questions** - The AI can clarify concepts if you're unsure

## Benefits of AI Verification

### With Claude Code:
- **Seamless workflow** - Verify without leaving your terminal
- **Automatic file detection** - No manual copy-pasting required
- **Context-aware analysis** - Understands your project structure
- **Instant feedback** - Results appear immediately in your development environment

### General Benefits:
- **Immediate feedback** - No waiting for instructor availability
- **Detailed explanations** - Learn WHY certain approaches are correct
- **Unlimited attempts** - Iterate and improve until you fully understand
- **Consistent evaluation** - Same criteria applied to all students
- **24/7 availability** - Get help whenever you're working on exercises

## Troubleshooting

### Claude Code Issues
- **"Can't find entity files"**: Ensure you're in the project root directory
- **"No documentation found"**: Make sure `Assessment.md` exists in your repo
- **"Command not recognized"**: Check Claude Code installation

### Manual Verification Issues  
- **AI doesn't understand context**: Make sure you copy the complete prompt from Assessment.md
- **Feedback seems generic**: Include both entity files in your submission
- **Technical issues**: Check that your code compiles and the application starts successfully

## Alternative AI Assistants

While we recommend Claude AI and Claude Code, you can also use:
- ChatGPT (OpenAI)
- Gemini (Google)  
- Any AI assistant capable of code analysis

For non-Claude assistants, use the manual verification method with the prompt from [Assessment.md](./Assessment.md).

## Getting Help

If you're having trouble with:
- **Claude Code verification**: Try the manual method as a backup
- **Understanding feedback**: Ask follow-up questions like "Can you explain the cascade configuration in more detail?"
- **Conceptual questions**: Use commands like `claude-code "explain JPA relationship ownership"`

Remember: The goal is learning, not just getting a PASS. Take time to understand the concepts behind the technical requirements!