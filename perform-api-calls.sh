#!/bin/bash

# JPA Training Exercise API Test Script
# Make sure your application is running on localhost:8080

BASE_URL="http://localhost:8080/jpa/training"

echo "==================================="
echo "JPA TRAINING EXERCISE API TESTS"
echo "==================================="

# Wait for application to be ready
echo "Waiting for application to start..."
sleep 2

echo ""
echo "===================="
echo "EXERCISE 1: PERSON-CAR (One-to-One Unidirectional)"
echo "===================="

echo ""
echo "1. GET all persons (should show sample data):"
curl -s -X GET "$BASE_URL/person" | jq '.' || curl -s -X GET "$BASE_URL/person"

echo ""
echo ""
echo "2. CREATE person with car:"
curl -s -X PUT "$BASE_URL/person" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Emma",
    "lastName": "Thompson",
    "department": "Marketing",
    "currentCar": {
      "make": "Tesla",
      "model": "Model 3",
      "numberPlate": "TES-001"
    }
  }' | jq '.' || curl -s -X PUT "$BASE_URL/person" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Emma",
    "lastName": "Thompson",
    "department": "Marketing",
    "currentCar": {
      "make": "Tesla",
      "model": "Model 3",
      "numberPlate": "TES-001"
    }
  }'

echo ""
echo ""
echo "3. CREATE person without car:"
curl -s -X PUT "$BASE_URL/person" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Mike",
    "lastName": "Brown",
    "department": "Finance",
    "currentCar": null
  }' | jq '.' || curl -s -X PUT "$BASE_URL/person" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Mike",
    "lastName": "Brown",
    "department": "Finance",
    "currentCar": null
  }'

echo ""
echo ""
echo "4. GET all persons again (should show new entries):"
curl -s -X GET "$BASE_URL/person" | jq '.' || curl -s -X GET "$BASE_URL/person"

echo ""
echo ""
echo "===================="
echo "EXERCISE 2: EMPLOYEE-BADGE (One-to-One Bidirectional)"
echo "===================="

echo ""
echo "1. GET all employees (should show sample data):"
curl -s -X GET "$BASE_URL/employee" | jq '.' || curl -s -X GET "$BASE_URL/employee"

echo ""
echo ""
echo "2. GET all badges (should show sample data with assigned employees):"
curl -s -X GET "$BASE_URL/badge" | jq '.' || curl -s -X GET "$BASE_URL/badge"

echo ""
echo ""
echo "3. CREATE employee with badge:"
curl -s -X PUT "$BASE_URL/employee" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Sarah",
    "lastName": "Connor",
    "department": "Security",
    "currentBadge": {
      "badgeNumber": "SEC-005",
      "accessLevel": "HIGH",
      "issueDate": "2024-03-01"
    }
  }' | jq '.' || curl -s -X PUT "$BASE_URL/employee" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Sarah",
    "lastName": "Connor",
    "department": "Security",
    "currentBadge": {
      "badgeNumber": "SEC-005",
      "accessLevel": "HIGH",
      "issueDate": "2024-03-01"
    }
  }'

echo ""
echo ""
echo "4. CREATE employee without badge:"
curl -s -X PUT "$BASE_URL/employee" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Tom",
    "lastName": "Hanks",
    "department": "HR",
    "currentBadge": null
  }' | jq '.' || curl -s -X PUT "$BASE_URL/employee" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Tom",
    "lastName": "Hanks",
    "department": "HR",
    "currentBadge": null
  }'

echo ""
echo ""
echo "5. GET all employees again (should show new entries):"
curl -s -X GET "$BASE_URL/employee" | jq '.' || curl -s -X GET "$BASE_URL/employee"

echo ""
echo ""
echo "6. GET all badges again (should show new badge with Sarah assigned):"
curl -s -X GET "$BASE_URL/badge" | jq '.' || curl -s -X GET "$BASE_URL/badge"

echo ""
echo ""
echo "===================="
echo "TESTING COMPLETE!"
echo "===================="
echo ""
echo "What to check:"
echo "✓ Person-Car: Cars should be automatically saved when saving persons"
echo "✓ Employee-Badge: Badges should be automatically saved when saving employees"
echo "✓ Bidirectional: Badge queries should show which employee they belong to"
echo "✓ Unidirectional: Car queries should NOT be available (no endpoint)"
echo ""
echo "Next steps:"
echo "1. Implement the JPA annotations in your entity classes"
echo "2. Run: claude-code 'verify my person-car one-to-one relationship exercise'"
echo "3. Run: claude-code 'verify my employee-badge one-to-one relationship exercise'"